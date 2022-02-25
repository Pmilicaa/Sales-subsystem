import { Table } from "react-bootstrap";
import OutputInvoice from "./OutputInvoice";
import React from 'react';
import AddOutputInvoice from "./AddOutputInvoice";

const OutputInvoices = ({ outputInvoices, invoice, articles, priceLists }) => {
  return (<>
    {outputInvoices && <><h1 className="center">Output invoices</h1>
      <Table className="table" striped bordered hover>
        <thead className="thead-dark">
          <tr>
            <th scope="col">Number account</th>
            <th scope="col">Total base</th>
            <th scope="col">Total pdv</th>
            <th scope="col">Total payment</th>
            <th scope="col">Release date</th>
          </tr>
        </thead>
        {outputInvoices.map((invoice) => <OutputInvoice invoice={invoice} />)}
      </Table> </>}
    <AddOutputInvoice priceLists={priceLists} />
  </>);
};
export default OutputInvoices;