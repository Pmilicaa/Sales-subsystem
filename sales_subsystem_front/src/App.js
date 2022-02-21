import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import TopNavbar from './components/TopNavbar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import UnitsOfMeasuresPage from './pages/UnitsOfMeasuresPage';
import { getAllArticles } from '../src/services/ArticleService'
import Articles from './components/articles/Articles';
import { useEffect, useState } from 'react';
import AddArticle from './components/articles/AddArticle';
import { getAllUnitOfMeasures } from './services/UnitOfMeasure';
import { addArticleGroup, getAllArticleGroups } from './services/ArticleGroupService';
import { getAllPrices } from './services/PriceListService';
import { getAllCompanies } from './services/CompanyService';
import AddArticleGroup from './components/articleGroups/AddArticleGroup';
import PriceLists from './components/priceList/PriceLists';
import AddPriceList from './components/priceList/AddPriceList';
import OnePriceList from './components/priceList/OnePriceList';

function App() {
  const [articles, setArticles] = useState([]);
  const [unitOfMeasures, setUnitOfMeasures] = useState();
  const [articleGroups, setArticleGroups] = useState();
  const [priceLists, setPriceLists]= useState([]);
  const [companies, setCompanies]= useState();
  useEffect(()=>{
    getAllArticles().then((article)=>setArticles(article));
    getAllUnitOfMeasures().then((unit)=>setUnitOfMeasures(unit));
    getAllArticleGroups().then((group)=>setArticleGroups(group));
    getAllPrices().then((price)=>setPriceLists(price));
    getAllCompanies().then((company)=>setCompanies(company));
  },[])
  // console.log(articles);
  // console.log(unitOfMeasures);
  // console.log(articleGroups);
  // console.log(priceLists);
  // console.log(companies);

  return (
    <>
      <Container>
      <TopNavbar />
      <BrowserRouter>
        <Routes>
        <Route path="/articles" element={<Articles articles={articles} articleGroups={articleGroups} companies={companies}/>}/>
          <Route path="/companies" />
          <Route path="/invoices" />
          <Route path="/addPriceList" element={<AddPriceList articles={articles} articleGroups={articleGroups} companies={companies}/>}/>
          <Route path="/priceList" element={<PriceLists priceLists={priceLists} articles={articles}/>}/>
          <Route path="/addArticleGroup" element={<AddArticleGroup articleGroups={articleGroups} companies={companies}/>}/>
          <Route path="/addArticle" element={<AddArticle unitOfMeasures={unitOfMeasures} articleGroups={articleGroups} priceList={priceLists} companies={companies}/>}/>
          <Route path="/units" element={<UnitsOfMeasuresPage/>} />
          </Routes>
      </BrowserRouter>
      </Container>
    </>
  )
}

export default App;
