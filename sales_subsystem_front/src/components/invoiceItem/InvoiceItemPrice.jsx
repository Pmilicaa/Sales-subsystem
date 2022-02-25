import { useState } from "react";
import { Button, Form, ListGroup } from "react-bootstrap";
import "./InvoiceItemPrice.css"

const InvoiceItemPrice = ({ article, addArticleToPriceList, setLockedPriceListItem }) => {
  const [discount, setDiscount] = useState(0);
  const [amount, setAmount] = useState(0);
  const [isLocked, setIsLocked] = useState(false);
  const handleOnChangeDiscount = (e) => {
    setDiscount(e.target.value)
  }
  const handleOnChangeAmount = (e) => {
    setAmount(e.target.value)
  }
  const handleLock = () => {
    let obj = {
      articleId: article.articleId,
      price: article.price,
      discount: discount,
      amount: amount
    }
    setLockedPriceListItem(
      oldArray => [...oldArray, obj])
    setIsLocked(true);
  }
  return (
    <>
      <ListGroup.Item action className="box">{article.name}
        <Form.Control onChange={handleOnChangeDiscount} type="number" placeholder="Enter discount" />
        <Form.Control className="ms-2" onChange={handleOnChangeAmount} type="number" placeholder="Enter amount" />
        {isLocked ? <Button className="ms-2" onClick={handleLock} disabled>Lock price</Button> : <Button className="ms-2" onClick={handleLock} >Lock price</Button>}
      </ListGroup.Item>
    </>
  )
}
export default InvoiceItemPrice;