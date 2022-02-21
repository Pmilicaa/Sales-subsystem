import React, { useState } from 'react'
import { Button, Form, Toast, ToastContainer } from 'react-bootstrap';
import { useForm } from 'react-hook-form';
import { addCompany } from '../../services/CompanyService';

const AddCompanyForm = () => {
  const { register, handleSubmit, getValues } = useForm({});
  const [ showToastFail, setShowToastFail ] = useState(false)
  const [ message, setMessage ] = useState("");

  const onSubmit = async data => {
    const newRes = await addCompany(data)
    if(newRes.status !== 200){
      setMessage(newRes.response.data.message)
      setShowToastFail(true)
    }
  }

  return (
    <>
    <Form onSubmit={handleSubmit(onSubmit)}>
      <Form.Group className="mb-3">
          <Form.Label>Address</Form.Label>
          <Form.Control name="address" type="text" placeholder="Enter address" {...register('address')}/>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Contact</Form.Label>
          <Form.Control name="contact" type="text" placeholder="Enter contact" {...register('contact')}/>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>PIB</Form.Label>
          <Form.Control name="pib" type="text" placeholder="Enter contact" {...register('pib')}/>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>MIB</Form.Label>
          <Form.Control name="mib" type="text" placeholder="Enter contact" {...register('mib')}/>
        </Form.Group>
        <Button type='submit' variant="primary">Add company</Button>
    </Form>
    <ToastContainer position='top-center'>
      <Toast onClose={() => setShowToastFail(false)} show={showToastFail} delay={7000} autohide>
        <Toast.Body>Company failed to add. Cause: {message}</Toast.Body>
      </Toast>
    </ToastContainer>
    </>
  )
}

export default AddCompanyForm