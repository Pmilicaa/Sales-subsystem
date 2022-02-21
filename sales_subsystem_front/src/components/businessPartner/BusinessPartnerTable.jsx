import React from 'react'
import { Table } from 'react-bootstrap'

const BusinessPartnerTable = ({ companies }) => {
  return (
    <Table className='mt-3' striped bordered hover>
      <thead>
        <tr>
          <th>Name</th>
          <th>Address</th>
          <th>Contact</th>
          <th>Email</th>
          <th>Company pib</th>
        </tr>
      </thead>
      <tbody>
        {companies.map((company) => 
          company.businessPartners.map((partner) => 
            <tr key={partner.id}>
              <td>{partner.namePartner}</td>
              <td>{partner.address}</td>
              <td>{partner.contact}</td>
              <td>{partner.eMail}</td>
              <td>{partner.pib}</td>
            </tr>
          )
        )}
      </tbody>
    </Table>
  )
}

export default BusinessPartnerTable