import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import DetailedInvoiceView from '../components/outputInvoice/DetailedInvoiceView'
import { getOutputInvoiceById } from '../services/OutputInvoicesService'

const DetailedInvoicePage = () => {
  const params = useParams()
  const [ invoice, setInvoice ] = useState({articleInvoices: [], totalPayment: 0})

  useEffect(() => {
    console.log("called")
    getOutputInvoiceById(params.id).then(receviedInvoice => setInvoice(receviedInvoice))
  }, [])

  return (
    <DetailedInvoiceView invoice={invoice} />
  )
}

export default DetailedInvoicePage