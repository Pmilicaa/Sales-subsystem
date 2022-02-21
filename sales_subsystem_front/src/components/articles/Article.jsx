import { useState } from "react";
import { Button } from "react-bootstrap";

const Article = ({ article, handleShow,setSelectedArticle }) => {
    const handleEdit =()=>{
        handleShow();
        setSelectedArticle(article);
    }
    return (<>
       
        <tbody>
            <tr>
                <td>{article.name}</td>
                <td>{article.description}</td>
                <td>{article.priceListItem.price}</td>
                {article.unitOfMeasure.shortName && <td>{article.unitOfMeasure.shortName}</td>}
                {/* <td>{article.articleGroup.company.pib}</td> */}
                <Button onClick={handleEdit} >Edit</Button>
            </tr>
        </tbody></>)
}
export default Article;