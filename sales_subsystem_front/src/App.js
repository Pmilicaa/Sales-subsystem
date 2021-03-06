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
import { getAllArticleGroups } from './services/ArticleGroupService';
import { getAllPrices } from './services/PriceListService';
import { getAllCompanies } from './services/CompanyService';
import AddArticleGroup from './components/articleGroups/AddArticleGroup';
import BusinessPartnerPage from './pages/BusinessPartnerPage';
import CompanyPage from './pages/CompanyPage';
import PriceLists from './components/priceList/PriceLists';
import AddPriceList from './components/priceList/AddPriceList';
import { getAllInvoices } from './services/InvoiceService';
import { getAllOutputInvoices } from './services/OutputInvoicesService';
import OutputInvoices from './components/outputInvoice/OutputInvoices';
import DetailedInvoicePage from './pages/DetailedInvoicePage';
import InvoicesBook from './pages/InvoicesBook';
import OutputInvoicesPage from './pages/OutputInvoicesPage';

function App() {
  const [articles, setArticles] = useState([]);
  const [unitOfMeasures, setUnitOfMeasures] = useState([]);
  const [articleGroups, setArticleGroups] = useState([]);
  const [priceLists, setPriceLists] = useState([]);
  const [companies, setCompanies] = useState([]);
  const [invoices, setInovices] = useState([]);
  const [outputInvoices, setOutputInvoices] = useState([]);

  useEffect(() => {
    getAllArticles().then((article) => setArticles(article));
    getAllUnitOfMeasures().then((unit) => setUnitOfMeasures(unit));
    getAllArticleGroups().then((group) => setArticleGroups(group));
    getAllPrices().then((price) => setPriceLists(price));
    getAllCompanies().then((company) => setCompanies(company));
    getAllInvoices().then((invoice) => setInovices(invoice));
    getAllOutputInvoices().then((output) => setOutputInvoices(output));
  }, [])

  return (
    <>
      <Container>
        <TopNavbar />
        <BrowserRouter>
          <Routes>
            <Route path="/articles" element={<Articles articles={articles} articleGroups={articleGroups} companies={companies} />} />
            <Route path="/companies" element={<CompanyPage companies={companies} />} />
            <Route path="/business" element={<BusinessPartnerPage companies={companies} />} />
            <Route path="/outputInvoices" element={<OutputInvoicesPage outputInvoices={outputInvoices} priceLists={priceLists} />} />
            <Route path="/invoiceDetails/:id" element={<DetailedInvoicePage />} />
            <Route path="/invoicesBook" element={<InvoicesBook />} />
            <Route path="/addPriceList" element={<AddPriceList articles={articles} articleGroups={articleGroups} companies={companies} />} />
            <Route path="/priceList" element={<PriceLists priceLists={priceLists} articles={articles} />} />
            <Route path="/addArticleGroup" element={<AddArticleGroup articleGroups={articleGroups} companies={companies} />} />
            <Route path="/addArticle" element={<AddArticle unitOfMeasures={unitOfMeasures} articleGroups={articleGroups} priceList={priceLists} companies={companies} />} />
            <Route path="/units" element={<UnitsOfMeasuresPage />} />
          </Routes>
        </BrowserRouter>
      </Container>
    </>
  )
}

export default App;
