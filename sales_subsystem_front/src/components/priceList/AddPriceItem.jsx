import { Button, Form } from "react-bootstrap";
import { useForm } from "react-hook-form";
import { addPriceList } from "../../services/PriceListService";

const AddPriceItem = (props) => {
    const { register, handleSubmit } = useForm({
    });
    const onSubmit = data => {
        addPriceList(props.selectedArticle.id,data.price);
        props.updateArticle(props.selectedArticle.id, data.price);
    };

    return (<>
     <Form onSubmit={handleSubmit(onSubmit)} className="component">
            <Form.Group className="mb-3" >
                <Form.Label>Price per unit</Form.Label>
                <Form.Control name="price" type="text" placeholder='Change price'  {...register('price')}
                />
            </Form.Group>
            <Button type='submit' variant="primary" className="margin-top">Add</Button>
        </Form>
    </>)
}
export default AddPriceItem;