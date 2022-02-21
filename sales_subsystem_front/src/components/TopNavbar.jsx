import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'

const TopNavbar = () => {
  return (
    <Navbar bg="light" expand="lg">
      <Container>
          <Nav className="me-auto">
            <Nav.Link href="/business">Business partners</Nav.Link>
            <Nav.Link href="/articles">Articles</Nav.Link>
            <Nav.Link href="/companies">Companies</Nav.Link>
            <Nav.Link href="/invoices">Invoices</Nav.Link>
            <Nav.Link href="/units">Units of measure</Nav.Link>
            <Nav.Link href="/priceList">Price list</Nav.Link>
          </Nav>
      </Container>
    </Navbar>
  )
}

export default TopNavbar