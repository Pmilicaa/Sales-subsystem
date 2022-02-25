import { useState } from "react";
import { Button, InputGroup } from "react-bootstrap";

const Article = ({ article, handleShow,setSelectedArticle,companies }) => {
    
    const handleEdit =()=>{
        handleShow();
        setSelectedArticle(article);
    }
    const getCompanyPib =()=>{
        let companyPib;
        for (let index = 0; index < companies.length; index++) {
            const company = companies[index];
            for (let index = 0; index < company.articles.length; index++) {
                const companyArticle = company.articles[index];
                if(companyArticle.id === article.id){
                  companyPib = company.pib;
                }
            }
        }
        return companyPib;
    }
    return (<>
       
        <tbody>
            <tr>
                <td>{article.name}</td>
                <td>{article.description}</td>
                <td>{article.priceListItem.price}</td>
                {article.unitOfMeasure.shortName && <td>{article.unitOfMeasure.shortName}</td>}
                <td>{article.articleGroup.name}</td>
                <td>{getCompanyPib()}</td>
                {/* <td>{article.articleGroup.company.pib}</td> */}
                {/* <Button onClick={handleEdit} >Edit</Button> */}
            </tr>
        </tbody></>)
}
export default Article;