import React, { useState } from 'react'
import { Button, Form } from 'react-bootstrap'
import { useForm } from 'react-hook-form';
import OutputInvoices from '../components/outputInvoice/OutputInvoices';
import { getOutputInvoicesByTimePeriod } from '../services/OutputInvoicesService';

const InvoicesBook = () => {
  const { register, handleSubmit } = useForm({});
  const [ outputInvoices, setOutputInvoices ] = useState([]);

  const onSubmit = data => {
    let beginning = new Date(data.beginning).getTime();
    let ending = new Date(data.ending) .getTime();

    getOutputInvoicesByTimePeriod(beginning, ending).then((outputInvoices) => setOutputInvoices(outputInvoices));
  };

  return (
    <>
      <h1 className="center">Invoices book</h1>
      <Form onSubmit={handleSubmit(onSubmit)}>
        <p className="center">Choose a time period</p>
        <Form.Group className="mb-3">
          <Form.Label>Beginning</Form.Label>
          <Form.Control name="beginning" type="date" placeholder='Enter beginning' {...register('beginning')}/>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Ending</Form.Label>
          <Form.Control name="ending" type="date" placeholder='Enter ending' {...register('ending')}/>
        </Form.Group>
        <Button type='submit' variant="primary">Search for invoices</Button>
      </Form>
      <OutputInvoices outputInvoices={outputInvoices} />
    </>
  )
}

export default InvoicesBook