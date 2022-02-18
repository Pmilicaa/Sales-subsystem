import { useState } from "react";
import { useNavigate } from "react-router-dom";
import ArticleGroup from "../articleGroups/ArticleGroup";

import './Articles.css';
const Articles = ({ articles,articleGroups }) => {
    let navigate = useNavigate();

    const getPrice = (article)=>{
        let price;
        if(article.priceLists.length === 0){
            return 'no price';
        }
        for (let index = 0; index < article.priceLists.length; index++) {
             price = article.priceLists[index].pricePerUnit;
        }
        return price;
    }
    const handleClick = ()=>{
        console.log('usao')
        navigate('/addArticle', { replace: true });
    }

    return (
        <>
         <h1 className="center">Articles</h1>
           {articles && <table className="table">
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
                   {articles.map((article)=>
                    <tr>
                        <td>{article.name}</td>
                        <td>{article.description}</td>
                        <td>{getPrice(article)}</td>
                       {article.unitOfMeasure.shortName && <td>{article.unitOfMeasure.shortName}</td>}
                        <td>{article.articleGroup.name}</td>
                        <td>{article.company.pib}</td>

                    </tr>)}
                </tbody>
            </table>}
           <div className="component"> <button type="submit" className="btn-primary" onClick={handleClick}>Add article</button></div>

           <ArticleGroup articleGroups={articleGroups}/>
        </>
    )
}
export default Articles;