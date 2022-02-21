import React from 'react'
import { Table } from 'react-bootstrap'

const CompanyTable = ({ companies }) => {
  return (
    <Table className="mt-3" striped bordered hover>
      <thead>
        <tr>
          <th>Address</th>
          <th>Contact</th>
          <th>PIB</th>
          <th>MIB</th>
        </tr>
      </thead>
      <tbody>
        {
          companies.map((company) => 
            <tr key={company.id}>
              <td>{company.address}</td>
              <td>{company.contact}</td>
              <td>{company.pib}</td>
              <td>{company.mib}</td>
            </tr>
          )
        }
      </tbody>
    </Table>
  )
}

export default CompanyTable