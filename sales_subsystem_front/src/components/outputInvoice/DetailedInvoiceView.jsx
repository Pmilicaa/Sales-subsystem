import React from 'react'
import { Table } from 'react-bootstrap'

const DetailedInvoiceView = ({ invoice }) => {
  return (
    <>
      { invoice == undefined ? <p>Loading</p> : <p>{invoice.id}</p>}
      <Table className="mt-3" striped bordered hover>
        <thead>
          <tr>
            <th>Article</th>
            <th>Price per unit</th>
            <th>Discount</th>
            <th>Amount</th>
            <th>Total for item</th>
          </tr>
        </thead>
        <tbody>
          {invoice.articleInvoices.map((articleInvoice) =>
            <tr>
              <td>{invoice == undefined ? "loading" : articleInvoice.article.name}</td>
              <td>{invoice == undefined ? "loading" : articleInvoice.invoiceItem.unitPrice}</td>
              <td>{invoice == undefined ? "loading" : articleInvoice.invoiceItem.discount}</td>
              <td>{invoice == undefined ? "loading" : articleInvoice.invoiceItem.amount}</td>
              <td>{invoice == undefined ? "loading" : articleInvoice.invoiceItem.total}</td>
            </tr>
          )}
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>{invoice.totalPayment}</td>
          </tr>
        </tbody>
      </Table>
    </>
  )
}

export default DetailedInvoiceView