import 'bootstrap/dist/css/bootstrap.min.css';
import { Button, Container } from 'react-bootstrap';
import TopNavbar from './components/TopNavbar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import UnitsOfMeasuresPage from './pages/UnitsOfMeasuresPage';

function App() {
  return (
    <>
      <Container>
      <TopNavbar />
      <BrowserRouter>
        <Routes>
          <Route path="/" />
          <Route path="/business" />
          <Route path="/articles" />
          <Route path="/companies" />
          <Route path="/invoices" />
          <Route path="/units" element={<UnitsOfMeasuresPage/>} />
        </Routes>
      </BrowserRouter>
      </Container>
    </>
  );
}

export default App;
