import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { getAllOutputInvoices } from "../../services/OutputInvoices";
import OutputInvoice from "./OutputInvoice";
import React from 'react';
import { useNavigate } from "react-router-dom";
import AddOutputInvoice from "./AddOutputInvoice";

const OutputInvoices =({outputInvoices,invoice, articles, priceLists})=>{
   console.log(priceLists);
    return(  <>
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
            {outputInvoices.map((invoice)=><OutputInvoice invoice={invoice}/>)}
        </Table> </>}
        {/* <InvoiceItems  invoices={invoices} articles={articles}/> */}
       <AddOutputInvoice priceLists={priceLists} />
        </>);
};
export default OutputInvoices;