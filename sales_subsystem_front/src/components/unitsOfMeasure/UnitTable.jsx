import React from 'react'
import { Table } from 'react-bootstrap'

const UnitTable = ({ units }) => {
  return (
    <Table className="mt-3" striped bordered hover>
      <thead>
        <tr>
          <th>Full name</th>
          <th>Short name</th>
        </tr>
      </thead>
      <tbody>
        {
          units.map((unit) => 
            <tr key={unit.id}>
              <td>{unit.name}</td>
              <td>{unit.shortName}</td>
            </tr>
          )
        }
      </tbody>
    </Table>
  )
}

export default UnitTable