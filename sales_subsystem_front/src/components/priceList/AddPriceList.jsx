import { useState } from "react";
import 'react-dual-listbox/lib/react-dual-listbox.css';
import DualListBox from 'react-dual-listbox';
import { Button, Col, Form, ListGroup, Row, Table } from "react-bootstrap";
import { set, useForm } from "react-hook-form";
import { addPriceList } from "../../services/PriceListService";
import ArticlePrice from "../articles/ArticlePrice";
import ArticlePriceRow from "../articles/ArticlePriceRow";
import ArticleGroup from "../articleGroups/ArticleGroup";


const AddPriceList = (props) => {
    const [selected, setSelected] = useState('one')
    const [show, setShow] = useState(false);
    const [ articlesInPriceList, setArticlesInPriceList ] = useState([])
    const [ allArticles, setAllArticles ] = useState(props.articles);
    const { register, handleSubmit } = useForm({});
    const [lockedPriceListItem, setLockedPriceListItem]=useState([])
    const [selectedArticle, setSelectedArticle] = useState({});
    const[isSaved, setIsSaved]= useState(false);
    const onSubmit = () => {
        addPriceList(lockedPriceListItem);
        setIsSaved(true);
    };

    const handleShow = () => {
        setShow(true); ;
    }

    const addArticleToPriceList = (article) => {
        setArticlesInPriceList(articlesInPriceList => [...articlesInPriceList, article])
    }

    const removeArticle = (article) => {
        let arrayWithRemovedArticle = allArticles.filter((articlesItem) => articlesItem.id != article.id)
        setAllArticles(arrayWithRemovedArticle)
    }

    const handleArticleClick = (article) => {
        addArticleToPriceList(article)
        removeArticle(article)
    }

    return (<>
  
            <h1 className="center">Add new price list with this articles</h1>
            {props.articles.length > 0 && <Table className="table" striped bordered hover>
            <thead className="thead-dark">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Unit of measure</th>
                <th scope="col">Article group</th>
                <th scope="col">PIB</th>
                <th scope="col">Add</th>

            </tr>
        </thead>
        {props.articles.map((article) =>
            <ArticlePriceRow key={article.id} article={article} />
        )}
    </Table>}   
    <Row>
        <Col>
            <ListGroup>
                {allArticles.map((article) => 
                    <ListGroup.Item action onClick={()=>handleArticleClick(article)}>{article.name}</ListGroup.Item>
                )}
            </ListGroup>
        </Col>
        <Col>
            {articlesInPriceList.length > 0 && <>
                <ListGroup className="mb-2">
                    {articlesInPriceList.map((articleInPriceList) => 
                        <ArticlePrice key={articleInPriceList.id} article={articleInPriceList} setLockedPriceListItem={setLockedPriceListItem} />
                    )}
                </ListGroup>
               {isSaved ? <Button onClick={onSubmit} disabled>Save price list</Button>:
               <Button onClick={onSubmit} >Save price list</Button>}
            </>}
        </Col>
    </Row>
    </>    
    )
}
export default AddPriceList;