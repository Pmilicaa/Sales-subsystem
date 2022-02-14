import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'react-bootstrap';
import TopNavbar from './components/TopNavbar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { getAllArticles } from '../src/services/ArticleService'
import Articles from './components/articles/Articles';
import { useEffect, useState } from 'react';

function App() {
  const [articles, setArticles] = useState();
  useEffect(()=>{
    const allArticles = getAllArticles().then((article)=>setArticles(article));
  },[])

  return (
    <>
      <TopNavbar />
      <BrowserRouter>
        <Routes>
          <Route path="/" />
          <Route path="/business" />
          <Route path="/articles" element={<Articles articles={articles}/>}/>
          <Route path="/companies" />
          <Route path="/invoices" />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
