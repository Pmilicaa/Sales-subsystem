import { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useForm } from "react-hook-form";
import { addCopyOfPriceLIst, getPriceList } from "../../services/PriceListService";

const CopyPriceListWithPDV =({priceList, id})=>{
    const [value, setValue] = useState('');
    const { register, handleSubmit } = useForm({
    });
    console.log(priceList)
    const onSubmit = data => {
        const articlePriceList= priceList;
        const pdv = data.pdv;
        const pdv_type = data.pdv_type;
        const priceListId =id;
        const item ={
            pdv,
            priceListId,
            pdv_type,
            priceListId,
            articlePriceList
        }
        console.log(data)
        addCopyOfPriceLIst(item);
        // const idUom = getUomId(data.uom);
        // const idGroup = getGroupId(data.group);
       // addArticle(data.name, data.description, data.price, idUom, idGroup, data.pib); console.log(data)
    };
   return(
   <>
      <Form onSubmit={handleSubmit(onSubmit)} className="component">
            <Form.Group className="mb-3" >
                <Form.Label>PDV</Form.Label>
                <Form.Control name="pdv" type="text" placeholder="Enter pdv"  {...register('pdv')}
                />
            </Form.Group>

            <div className="form">
                <p>Select type</p>
                <Form.Select aria-label="Select type" {...register('pdv_type')} className="form-element" >
                    <option value='increase' name="pdv_type">increase the price</option>
                    <option value='decrease' name="pdv_type">decrease the price</option>
                </Form.Select>
            </div>
         <Button type='submit' variant="primary" className="margin-top">Edit</Button>
        </Form>
   
   </>) 
}
export default CopyPriceListWithPDV;