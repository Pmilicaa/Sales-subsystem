import React, { useState } from 'react'
import axios from 'axios';
import { Button, Form, Toast, ToastContainer } from 'react-bootstrap'

const AddUnitForm = ({ addUnit }) => {
  const [name, setName] = useState("")
  const [shortname, setShortname] = useState("")
  const [ showToast, setShowToast ] = useState(false)
  const [ showToastFail, setShowToastFail ] = useState(false)

  const handleAddUnitClick = () => {
    let unitOfMeasure = {
      name: name,
      shortName: shortname,
    }

    addUnitOfMeasure(unitOfMeasure)
  }

  const handleNameInput = (e) => {
    setName(e.target.value)
  }

  const handleShortnameInput = (e) => {
    setShortname(e.target.value)
  }

  async function addUnitOfMeasure(unitOfMeasure) {
    axios.post('http://localhost:8080/unitOfMeasures', unitOfMeasure)
      .then(function (res) {
        setShowToast(true)
        addUnit(unitOfMeasure)
      })
      .catch(function (error) {
        setShowToastFail(true)
      });
  }

  return (
    <>
      <Form>
        <Form.Group className="mb-3" controlId="nameControl">
          <Form.Label>Name</Form.Label>
          <Form.Control onChange={handleNameInput} type="text" placeholder="Enter unit name" />
        </Form.Group>
        <Form.Group className="mb-3" controlId="shortnameControl">
          <Form.Label>Short name</Form.Label>
          <Form.Control onChange={handleShortnameInput} type="text" placeholder="Enter unit shortname" />
        </Form.Group>
        <Button variant="primary" onClick={handleAddUnitClick}>
          Add unit
        </Button>
      </Form>
      <ToastContainer position='top-center'>
      <Toast onClose={() => setShowToast(false)} show={showToast} delay={3000} autohide>
        <Toast.Body>Unit of measure successfully added</Toast.Body>
      </Toast>
      <Toast onClose={() => setShowToastFail(false)} show={showToastFail} delay={3000} autohide>
        <Toast.Body>Unit of measure failed to add</Toast.Body>
      </Toast>
      </ToastContainer>
    </>
  )
}

export default AddUnitForm