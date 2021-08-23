import {getArticles} from "./ArticlesUtil.js";
$(document).ready(function(){

    getArticles(function(retVal){
        retVal.forEach(function(article){
            appendArticle(article);
            console.log(article);
        });
    });

   function getPrice(article){
       var priceListPerUnit;
       if(article.priceLists.length == 0){
           return "no price";
       }
       for(var i = 0; article.priceLists.length > i; i++){
           priceListPerUnit = article.priceLists[i].pricePerUnit;
       }
       return priceListPerUnit;

   }
  function appendArticle(article){
        $("#tableArticles").append("<tr>" +
                "<td>" + article.name+ "</td>" +
                "<td>" + article.description + "</td>" +
                "<td>" + getPrice(article) + "</td>" +
                "<td>" + article.unitOfMeasure.shortName+ "</td>" +
                "<td>" + article.articleGroup.name+ "</td>" +
                "<td>" + article.company.pib + "</td>" +

                "</tr>"
        );
    }


});