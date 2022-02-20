import { useState } from "react";
import { Button, Form, ListGroup } from "react-bootstrap";

const ArticlePrice = ({ article, addArticleToPriceList,setLockedPriceListItem }) => {
    const [ price, setPrice ] = useState(0);
    const[isLocked, setIsLocked]=useState(false);
    const handleOnChange = (e) => {
        setPrice(e.target.value)
    }
    const handleLock =()=>{
        let obj={
            articleId:article.id,
            price:price
        }
        setLockedPriceListItem(
            oldArray => [...oldArray,obj ])
        setIsLocked(true);
    }
    return (
        <>
           <ListGroup.Item action >{article.name}
             <Form.Control onChange={handleOnChange} type="number" placeholder="Enter price" />
            {isLocked ? <Button onClick={handleLock} disabled>Lock price</Button> :<Button onClick={handleLock} >Lock price</Button> }
           </ListGroup.Item>
        </>
    )
}
export default ArticlePrice;