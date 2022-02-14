import { useState } from "react";
import './Articles.css';
const Articles = ({ articles }) => {

    const getPrice = (article)=>{
        let price;
        if(article.priceLists === 0){
            return 'no price';
        }
        for (let index = 0; index < article.priceLists.length; index++) {
             price = article.priceLists[index].pricePerUnit;
        }
        return price;
    }

    return (
        <>
         <h1 className="center">Articles</h1>
           {articles && <table class="table">
                <thead class="thead-dark">
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
                        <td>{article.unitOfMeasure.shortName}</td>
                        <td>{article.articleGroup.name}</td>
                        <td>{article.company.pib}</td>

                    </tr>)}
                </tbody>
            </table>}
        </>
    )
}
export default Articles;