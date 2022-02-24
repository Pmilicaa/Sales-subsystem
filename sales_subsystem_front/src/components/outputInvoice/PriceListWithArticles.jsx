import { useEffect, useState } from "react";
import { Button, Col, Form, ListGroup, Row, Table } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { addOutputInvoice } from "../../services/OutputInvoices";
import { getPriceList } from "../../services/PriceListService";
import InvoiceItemPrice from "../invoiceItem/InvoiceItemPrice";

const PriceListWithArticles = (props) => {
    const [ articlesInPriceList, setArticlesInPriceList ] = useState([])
    const [priceList, setPriceList]= useState([]);
    const [ allPriceList, setAllPriceList ] = useState([]);
    const [lockedPriceListItem, setLockedPriceListItem]=useState([])
    const[isClicked, setIsClicked]=useState(false);
    const[isSaved, setIsSaved]= useState(false);

    useEffect(()=>{
        getPriceLists(props.id);
    }
    ,[]);
    const addArticleToPriceList = (article) => {
        setArticlesInPriceList(articlesInPriceList => [...articlesInPriceList, article])
    }

    const removeArticle = (article) => {
        let arrayWithRemovedArticle = allPriceList.filter((articlesItem) => articlesItem.id != article.id)
        setAllPriceList(arrayWithRemovedArticle)
    }
     const handleArticleClick = (article) => {
        addArticleToPriceList(article)
        removeArticle(article)
        setIsClicked(!isClicked);
    }

    const onSubmit = () => {
        console.log(lockedPriceListItem);
           addOutputInvoice(lockedPriceListItem);
           setIsSaved(true);
    };
       const removeArticleFromPriceList= (article) => {
           let arrayWithRemovedArticle = allPriceList.filter((articlesItem) => articlesItem.id != article.id)
           setAllPriceList(arrayWithRemovedArticle)
       }
    console.log(props.id);
    const getDate = (date) => {
        var options = { weekday: 'short', year: 'numeric', month: 'short', day: 'numeric', hour: 'numeric', minute: 'numeric' };
        return (new Date(date).toLocaleDateString('en-US', options));
       
    }
    const getPriceLists = (id)=>{
    console.log(id);
       const prices =  getPriceList(id).then((price)=>setPriceList(price));
       console.log(priceList)
      
    }
    
    return (<>
        <h1 className="center">One price list</h1>
        {priceList && <Table className="table" striped bordered hover>
            <thead className="thead-dark">
                <tr>
                    <th scope="col">Valid from</th>
                    <th scope="col">Article name</th>
                    <th scope="col">Article group</th>
                    <th scope="col">Price</th>
                    <th scope="col">Company PIB</th>
                </tr>
            </thead>
            <tbody>
            {priceList.map((price)=>
            <tr>
            <td>{getDate(price.validDate)}</td>
            <td>{price.articleName}</td>
            <td>{price.articleGroupName}</td>
            <td>{price.price}</td>
            <td>{price.pib}</td>
        </tr>)
    }

            </tbody>

        </Table>}
        <Row>
     <Col>
            <ListGroup>
                {priceList.map((article) => 
                 <ListGroup.Item action onClick={()=>handleArticleClick(article)} >{article.articleName} {article.price}</ListGroup.Item> 
                )}
            </ListGroup>
        </Col>
        <Col>
            {articlesInPriceList.length > 0 && <>
                <ListGroup className="mb-2">
                    {articlesInPriceList.map((articleInPriceList) => 
                        <InvoiceItemPrice key={articleInPriceList.id} article={articleInPriceList} setLockedPriceListItem={setLockedPriceListItem} />
                    )}
                </ListGroup>
               {isSaved ? <Button onClick={onSubmit} disabled>Save price list</Button>:
               <Button onClick={onSubmit} >Save output invoice</Button>}
            </>}
        </Col>
    </Row>    
    </>);
}
export default PriceListWithArticles;