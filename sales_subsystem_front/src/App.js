import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'react-bootstrap';
import TopNavbar from './components/TopNavbar';
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
     <BrowserRouter>
     <Routes>
       <Route path="/" element={<TopNavbar />}/>
       <Route path="/articles"/>
       <Route path="/companies"/>
       <Route path="/invoices"/>
     </Routes>
   </BrowserRouter>
  );
}

export default App;
