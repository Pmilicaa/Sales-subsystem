import { Button, Form } from "react-bootstrap";
import { useForm } from "react-hook-form";
import { addPriceList } from "../../services/PriceListService";

const PriceList = (props) => {
  const { register, handleSubmit } = useForm({});

  const onSubmit = data => {
    addPriceList(props.article, data);
  };

  return (<>
    <Form onSubmit={handleSubmit(onSubmit)} className="component">
      <Form.Group className="mb-3" >
        <Form.Label>Price per unit</Form.Label>
        <Form.Control name="price" type="text" placeholder="Enter price"  {...register('price')}
        />
      </Form.Group>
      <Button type='submit' variant="primary" className="margin-top">Add</Button>
    </Form>
  </>)
}

export default PriceList;