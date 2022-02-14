import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'

const TopNavbar = () => {
  return (
    <Navbar bg="light" expand="lg">
      <Container>
          <Nav className="me-auto">
            <Nav.Link href="#home">Business partners</Nav.Link>
            <Nav.Link href="#link">Article groups</Nav.Link>
            <Nav.Link href="#link">Companies</Nav.Link>
            <Nav.Link href="#link">Invoices</Nav.Link>
          </Nav>
      </Container>
    </Navbar>
  )
}

export default TopNavbar