import React from 'react'
import OutputInvoices from "../components/outputInvoice/OutputInvoices"
import AddOutPutInvoice from "../components/outputInvoice/AddOutputInvoice"

const OutputInvoicesPage = ({ outputInvoices, priceLists }) => {
  return (
    <>
      <OutputInvoices outputInvoices={outputInvoices} />
      <AddOutPutInvoice priceLists={priceLists} />
    </>
  )
}

export default OutputInvoicesPage