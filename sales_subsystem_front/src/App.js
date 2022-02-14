import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'react-bootstrap';
import TopNavbar from './components/TopNavbar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { getAllArticles } from '../src/services/ArticleService'
import Articles from './components/Articles';

function App() {
  const articles = getAllArticles();

  return (
    <>
      <TopNavbar />
      <BrowserRouter>
        <Routes>
          <Route path="/" />
          <Route path="/business" />
          <Route path="/articles" elemente={<Articles param={articles}/>}/>
          <Route path="/companies" />
          <Route path="/invoices" />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
