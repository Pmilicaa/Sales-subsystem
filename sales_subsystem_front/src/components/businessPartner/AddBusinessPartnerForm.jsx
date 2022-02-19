import React from 'react'
import { useForm } from 'react-hook-form';

import { Button, Form } from 'react-bootstrap'
import { addBusinessPartner } from '../../services/BusinessPartnerService';

const AddBusinessPartnerForm = ({ companies }) => {
  const { register, handleSubmit,getValues } = useForm({});

  const onSubmit = data => {
      addBusinessPartner(data);
  };

  return (
    <>
      <Form onSubmit={handleSubmit(onSubmit)}>
      <Form.Group className="mb-3">
          <Form.Label>Partner name</Form.Label>
          <Form.Control name="namePartner" type="text" placeholder="Enter name" {...register('namePartner')}/>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Address</Form.Label>
          <Form.Control name="address" type="text" placeholder="Enter address" {...register('address')}/>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Contact</Form.Label>
          <Form.Control name="contact" type="text" placeholder="Enter contact" {...register('contact')}/>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Email</Form.Label>
          <Form.Control name="eMail" type="text" placeholder="Enter email" {...register('eMail')}/>
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>PIB</Form.Label>
          <Form.Select aria-label="Default select example" {...register('pib')}>
            <option>Choose pib</option>
            {
              companies.map((company) => <option key={company.pib} value={company.pib}  >{company.pib}</option>)
            }
          </Form.Select>
        </Form.Group>
        
        <Button type='submit' variant="primary">Add partner</Button>
      </Form>
    </>
  )
}

export default AddBusinessPartnerForm