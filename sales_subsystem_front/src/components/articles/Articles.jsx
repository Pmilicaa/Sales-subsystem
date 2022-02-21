import { useEffect, useState } from "react";
import { Button, Modal, Table } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import ArticleGroup from "../articleGroups/ArticleGroup";
import AddPriceItem from "../priceList/AddPriceItem";
import Article from "./Article";

import './Articles.css';
const Articles = ({ articles, articleGroups, companies }) => {
    const [ allArticles, setAllArticles ] = useState(articles);
    const [selectedArticle, setSelectedArticle] = useState({});
    let navigate = useNavigate();

    useEffect(() => {
        setAllArticles(articles)
    }, [articles])
    //console.log(articles);
    //console.log(articleGroups);
    //console.log(companies);
    const [show, setShow] = useState(false);
    const getPrice = (article) => {
        let price;
        if (article.priceLists.length === 0) {
            return 'no price';
        }
        for (let index = 0; index < article.priceLists.length; index++) {
            price = article.priceLists[index].pricePerUnit;
        }
        return price;
    }
    const handleClick = () => {
        navigate('/addArticle', { replace: true });
    }

    const handleClose = () => setShow(false);
    const handleShow = () => {
        setShow(true); ;
    }

    const updateArticle = (articleId, price) => {
        allArticles.map((article) => {
            if(article.id == articleId){
                article.priceListItem.price = price
            }
        })
    }

    return (
        <>
            <h1 className="center">Articles</h1>
            {allArticles.length > 0 && <Table className="table" striped bordered hover>
            <thead className="thead-dark">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Unit of measure</th>
                <th scope="col">Article group</th>
                <th scope="col">PIB</th>
            </tr>
        </thead>
                    {allArticles.map((article) =>
                       <Article article={article} handleShow={handleShow} setSelectedArticle={setSelectedArticle} />
                     ) }
            </Table>}
            <Modal
                show={show}
                onHide={handleClose}
                backdrop="static"
                keyboard={false}
            >
                <Modal.Header closeButton>
                    <Modal.Title>Add new price</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <AddPriceItem selectedArticle={selectedArticle} updateArticle={updateArticle} />
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
            <div className="component"> <button type="submit" className="btn-primary" onClick={handleClick}>Add article</button></div>

            {/* <ArticleGroup articleGroups={articleGroups} companies={companies} /> */}
        </>
    )
}
export default Articles;