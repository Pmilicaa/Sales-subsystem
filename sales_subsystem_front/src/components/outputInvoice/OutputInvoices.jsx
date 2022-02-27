import { Table } from "react-bootstrap";
import OutputInvoice from "./OutputInvoice";
import React from 'react';

const OutputInvoices = ({ outputInvoices }) => {
  return (
    <>
      <h1 className="center">Output invoices</h1>
      <Table className="table" striped bordered hover>
        <thead className="thead-dark">
          <tr>
            <th scope="col">Number account</th>
            <th scope="col">Total base</th>
            <th scope="col">Total pdv</th>
            <th scope="col">Total payment</th>
            <th scope="col">Release date</th>
            <th scope="col">Options</th>
          </tr>
        </thead>
        <tbody>
          {outputInvoices.map((invoice) => <OutputInvoice invoice={invoice} />)}
        </tbody>
      </Table> 
    </>
  );
};
export default OutputInvoices;