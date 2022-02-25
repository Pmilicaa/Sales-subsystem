import { useEffect, useState } from "react";
import { Button, Col, Form, ListGroup, Row, Table } from "react-bootstrap";
import { useForm } from "react-hook-form";
import { getAllBusinessPartners } from "../../services/BusinessPartnerService";
import { addOutputInvoice } from "../../services/OutputInvoices";
import { getPriceList } from "../../services/PriceListService";
import InvoiceItemPrice from "../invoiceItem/InvoiceItemPrice";
import { formatMillis } from "../../utils/time";

const PriceListWithArticles = ({ id }) => {
    const { register, handleSubmit } = useForm({});

    const [ businessPartners, setBusinessPartners ] = useState([])
    const [ articlesInPriceList, setArticlesInPriceList ] = useState([])
    const [ priceList, setPriceList ] = useState([]);
    const [ allPriceList, setAllPriceList ] = useState([]);
    const [ lockedPriceListItems, setLockedPriceListItems ] = useState([])
    const [ isClicked, setIsClicked ] = useState(false);
    const [ isSaved, setIsSaved ] = useState(false);

    useEffect(()=>{
        getPriceLists(id);
        getAllBusinessPartners().then((receivedBusinessPartners) => setBusinessPartners(receivedBusinessPartners));
    },[]);

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

    const onSubmit = data => {
        let priceItemsAndPartner = {
            priceListId: id,
            businessPartnerId: data.partner,
            addInvoiceItemDtoList: lockedPriceListItems
        }
        console.log(priceItemsAndPartner)
        addOutputInvoice(priceItemsAndPartner);
        setIsSaved(true);
    };

    const removeArticleFromPriceList= (article) => {
        let arrayWithRemovedArticle = allPriceList.filter((articlesItem) => articlesItem.id != article.id)
        setAllPriceList(arrayWithRemovedArticle)
    }

    

    const getPriceLists = (id)=>{
       getPriceList(id).then((price)=>setPriceList(price));
    }
    
    return (
        <>
            <h1 className="center">One price list</h1>
            {priceList && 
            <Table className="table" striped bordered hover>
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
                            <td>{formatMillis(price.validDate)}</td>
                            <td>{price.articleName}</td>
                            <td>{price.articleGroupName}</td>
                            <td>{price.price}</td>
                            <td>{price.pib}</td>
                        </tr>
                    )}
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
                    {articlesInPriceList.length > 0 && 
                        <>
                            <ListGroup className="mb-2">
                                {articlesInPriceList.map((articleInPriceList) => 
                                    <InvoiceItemPrice key={articleInPriceList.id} article={articleInPriceList} setLockedPriceListItem={setLockedPriceListItems} />
                                )}
                            </ListGroup>
                            <Form onSubmit={handleSubmit(onSubmit)}>
                                <Form.Select aria-label="Select group" {...register('partner')} className="form-element" >
                                    {
                                        businessPartners.map((businessPartner) => 
                                            <option key={businessPartner.id} value={businessPartner.id} name="partner">{businessPartner.namePartner}</option>
                                        )
                                    }
                                </Form.Select>
                                {isSaved ? <Button variant="primary" disabled>Save invoice</Button>:
                                <Button type="submit" variant="primary">Save invoice</Button>}
                            </Form>
                        </>
                    }
                </Col>
            </Row>    
        </>
    );
}
export default PriceListWithArticles;