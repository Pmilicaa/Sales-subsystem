import { Button, Form } from "react-bootstrap";
import { useForm } from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';
import * as Yup from 'yup';
import './AddArticles.css'
import { addArticle } from "../../services/ArticleService";
import { useState } from "react";

const AddArticle = (props) => {
    const [value, setValue] = useState(100);
    const validationSchema = Yup.object().shape({
        name: Yup.string().required('Name is required'),
        description: Yup.string()
            .required('Description is required')
            .min(6, 'Description must be at least 6 characters')
            .max(200, 'Description must not exceed 200 characters'),
        price: Yup.string()
            .required('Price is required'),
        uom: Yup.string()
            .required('Unit of measure is required')
            .min(1, 'Unit of measure must be at least 1 characters')
            .max(2, 'Unit of measure must not exceed 2 characters'),
        pib: Yup.string()
            .required('PIB is required')
            .min(2, 'PIB must be at least 2 characters')
            .max(200, 'PIB must not exceed 200 characters'),
    });
    const { register, handleSubmit } = useForm({
    });

    const getUomId = (uom) => {
        let idUom;
        for (let index = 0; index < props.unitOfMeasures.length; index++) {
            if (props.unitOfMeasures[index].shortName == uom) {
                idUom = props.unitOfMeasures[index].id;
            }
        } return idUom;
    }
    const getGroupId = (group) => {
        let id;
        for (let index = 0; index < props.articleGroups.length; index++) {
            if (props.articleGroups[index].name == group) {
                id = props.articleGroups[index].id;
            }
        } return id;
    }
    const onSubmit = data => {
        const idUom = getUomId(data.uom);
        const idGroup = getGroupId(data.group);
        addArticle(data.name, data.description, data.price, idUom, idGroup, data.pib); console.log(data)
    };
    const handleOnChange = (e) => {
        console.log(e.target.value)
        setValue(e.target.value);
    };
    return (<>
        <h1 className="center">Add Article</h1>
        <Form onSubmit={handleSubmit(onSubmit)} className="component">
            <Form.Group className="mb-3" >
                <Form.Label>Article name</Form.Label>
                <Form.Control name="name" type="text" placeholder="Enter article name"  {...register('name')}
                />
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label>Description</Form.Label>
                <Form.Control type="text" placeholder="Enter description" {...register('description')} />
            </Form.Group>
            <Form.Group className="mb-3">
                    <Form.Label>Input price</Form.Label>
                    <Form.Control placeholder="Price" name="price" {...register('price')} />
                </Form.Group>
            <div className="form">
                <Form.Group className="mb-3" className="text-center" >
                    <Form.Label className="form-element">Select group</Form.Label>
                    <Form.Control as="select" className="center" custom onChange={() => handleOnChange} defaultValue={value}>
                        {props.articleGroups && props.articleGroups.map((group) => <option name="group" value={group.name}  {...register('group')}>{group.name}</option>)}
                    </Form.Control>
                </Form.Group>
            
                <Form.Group className="mb-3" className='text-center' >
                    <Form.Label className="form-element">Unit of measure</Form.Label>
                    <Form.Control as="select" custom onChange={() => handleOnChange} defaultValue={value}>
                        {props.unitOfMeasures && props.unitOfMeasures.map((unit) => <option name="uom" value={unit.shortName} {...register('uom')}>{unit.shortName}</option>)}
                    </Form.Control>
                </Form.Group>

                <Form.Group className="mb-3" className="text-center">
                    <Form.Label className="form-element">PIB</Form.Label>
                    <Form.Control as="select" className="center" custom onChange={() => handleOnChange} defaultValue={value}>
                        {props.companies && props.companies.map((company) => <option name="pib" value={company.pib} {...register('pib')}>{company.pib}</option>)}
                    </Form.Control>
                </Form.Group>
            </div>
            <Button type='submit' variant="primary">Add</Button>
        </Form>
    </>
    )
}
export default AddArticle;