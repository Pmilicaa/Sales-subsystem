import { useState } from "react";
import { Button, Col, Form, ListGroup, Row, Table } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import InvoiceItem from "./InvoiceItem";
import "./InvoiceItemPrice.css"
const InvoiceItemPrice = ({ article, addArticleToPriceList,setLockedPriceListItem })=>{
    const [ discount, setDiscount ] = useState(0);
    const [ amount, setAmount ] = useState(0);
    const[isLocked, setIsLocked]=useState(false);
    const handleOnChangeDiscount = (e) => {
        setDiscount(e.target.value)
    }
    const handleOnChangeAmount = (e) => {
        setAmount(e.target.value)
    }
    console.log(article)
    const handleLock =()=>{
        let obj={
            articleId:article.articleId,
            price: article.price,
            discount:discount,
            amount:amount
        }
        setLockedPriceListItem(
            oldArray => [...oldArray,obj ])
        setIsLocked(true);
    }
    return (
        <>
           <ListGroup.Item action className="box">{article.name}
             <Form.Control onChange={handleOnChangeDiscount} type="number" placeholder="Enter discount" />
             <Form.Control onChange={handleOnChangeAmount} type="number" placeholder="Enter amount" />
            {isLocked ? <Button onClick={handleLock} disabled>Lock price</Button> :<Button onClick={handleLock} >Lock price</Button> }
           </ListGroup.Item>
        </>
    )
}
export default InvoiceItemPrice;