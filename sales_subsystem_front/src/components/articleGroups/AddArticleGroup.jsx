import { addArticleGroup } from "../../services/ArticleGroupService";

import { Button, Form } from "react-bootstrap";
import { useForm } from "react-hook-form";
import { useState } from "react";
import './index.css'
const AddArticleGroup = (props)=>{
    const { register, handleSubmit,getValues } = useForm({
    });
    const onSubmit = data => {
        console.log(data)
        addArticleGroup(data);
    };
    const handleOnChange = (e) => {
        console.log(e.target.value)
       
    };
return(<>
    <h1 className="center">Add Article Group</h1>
    <Form onSubmit={handleSubmit(onSubmit)} className="component">
        <Form.Group className="mb-3 text-center" >
            <Form.Label>Group name</Form.Label>
            <Form.Control name="name" type="text" placeholder="Enter article name"  {...register('name')}
            />
        </Form.Group>
        <div className="form">
            <Form.Group className="mb-3" className="text-center">
                <Form.Label className="form-element">PIB</Form.Label>
                <Form.Control as="select" className="center" custom className="size" >
                    {props.companies && props.companies.map((company) => <option name="pib"  {...register('pib')}>{company.pib}</option>)}
                </Form.Control>
            </Form.Group>
        </div>
        <Button type='submit' variant="primary" className="margin-top" onClick={() => {
          const values = getValues("pib");
        }}>Add</Button>
    </Form>
</>)
}
export default AddArticleGroup;