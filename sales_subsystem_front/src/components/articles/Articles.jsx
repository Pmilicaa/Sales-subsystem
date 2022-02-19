import { useState } from "react";
import { Button, Modal, Table } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import ArticleGroup from "../articleGroups/ArticleGroup";
import PriceList from "../priceList/PriceList";

import './Articles.css';
const Articles = ({ articles, articleGroups, companies }) => {
    let navigate = useNavigate();
    console.log(articles);
    console.log(articleGroups);
    console.log(companies);
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
        console.log('usao')
        navigate('/addArticle', { replace: true });
    }

    const handleClose = () => setShow(false);
    const handleShow = () => {
        setShow(true); ;
    }

    return (
        <>
            <h1 className="center">Articles</h1>
            {articles && <Table className="table" striped bordered hover>
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
                <tbody>
                    {articles.map((article) =>
                        <tr>
                            <td>{article.name}</td>
                            <td>{article.description}</td>
                            <td>{article.priceListItem.price}</td>
                            {article.unitOfMeasure.shortName && <td>{article.unitOfMeasure.shortName}</td>}
                            <td>{article.company.pib}</td>
                            <Button type="submit" onClick={handleShow} >Edit</Button>

                        </tr>)}
                </tbody>
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
                    <PriceList  />
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
            <div className="component"> <button type="submit" className="btn-primary" onClick={handleClick}>Add article</button></div>

            <ArticleGroup articleGroups={articleGroups} companies={companies} />
        </>
    )
}
export default Articles;