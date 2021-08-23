import {getArticles} from "./ArticlesUtil.js";
import {getUnitOfMeasures} from "./UnitOfMeasureUtil.js";
import {getArticleGroups} from "./ArticleGroupUtil.js";
import {getCompanies} from "./CompanyUtil.js"
$(document).ready(function(){

    var unitOfStateSelected = $('#inputUnitOfState');
    var articleGroupSelected = $('#inputArticleGroup');
    var companySelected = $('#inputCompany');
    var unitOfMeasures = [];
    var articleGroups =[];
    var companies=[];
    getUnitOfMeasures(function(retVal){
        unitOfMeasures = retVal;
        retVal.forEach(function(unitOfMeasure){
            unitOfStateSelected.append("<option values='" + unitOfMeasure.shortName + "'>" + unitOfMeasure.shortName + "</option>");
        });
    });
    getArticleGroups(function(retVal){
        articleGroups = retVal;
        retVal.forEach(function(articleGroup){
            console.log(articleGroup);
            articleGroupSelected.append("<option values='" + articleGroup.name + "'>" + articleGroup.name + "</option>");
        });
    });
     getCompanies(function(retVal){
         companies = retVal;
         retVal.forEach(function(company){
             console.log(company);
             companySelected.append("<option values='" + company.pib + "'>" + company.pib + "</option>");
         });
     });

    function uom(){
        var unitOfMeasure;
        for(var i = 0; unitOfMeasures.length > i; i++){
            if(unitOfMeasures[i].shortName == unitOfStateSelected.val()){
                unitOfMeasure=unitOfMeasures[i];
                return unitOfMeasure;
            }
        }
        console.log(unitOfMeasure);
    }
    function ag(){
        var articleGroup;
        for(var i=0; articleGroups.length > i; i++){
            if(articleGroups[i].name == articleGroupSelected.val()){
                articleGroup=articleGroups[i];
                return articleGroup;
            }
        }

    }
    function cmp(){
        var company;
        for(var i=0; companies.length > i; i++){
            if(companies[i].pib == companySelected.val()){
                company = companies[i];
                return company;
            }
        }
    }
    $('#addArticle').on('click', function(event){

        event.preventDefault();
        var inputName = $('#inputName').val();
        var inputDesc = $('#inputDesc').val();
        var inputPrice = $('#inputPrice').val();
        var inputCompany = $('#inputCompany').val();
        console.log(inputName);
        console.log(unitOfMeasures);
        var data = {
            'name': inputName,
            'description': inputDesc,
            'priceLists': [{
                'validFrom': '2020-12-12',
                'pricePerUnit': 13
            }],
            'unitOfMeasure': uom(),
            'articleGroup': ag(),
            'company': cmp()

        }
        console.log(uom());
        console.log(data);

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/articles',
        	 data: JSON.stringify(data),
        	success :function(answer) {
        	    alert("dodali ste");
        	},
        	contentType: 'application/json'
        });

    })

});