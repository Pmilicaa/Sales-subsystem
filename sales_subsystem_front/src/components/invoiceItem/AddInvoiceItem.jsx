import { Button, Form } from "react-bootstrap";
import { useForm } from "react-hook-form";

const AddInvoiceItem =(props)=>{
    const { register, handleSubmit } = useForm({});
    const onSubmit = data => {
        console.log(data);
        getArticleId(data.articleName);
        // const idUom = getUomId(data.uom);
        // const idGroup = getGroupId(data.group);
        // addArticle(data.name, data.description, data.price, idUom, idGroup, data.pib); console.log(data)
    };
    console.log(props.priceLists);
    const getArticleId = (articleName) => {
        let id;
        for (let index = 0; index < props.articles.length; index++) {
            if (props.articles[index].name == articleName) {
                id = props.articles[index].id;
            }
        } return id;
    }
  return(<>
   <h1 className="center">Add invoice</h1>
        <Form onSubmit={handleSubmit(onSubmit)} className="component">
           
            <Form.Group className="mb-3">
                <Form.Label>amount</Form.Label>
                <Form.Control type="text" placeholder="Enter amount" {...register('amount')} />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>discount</Form.Label>
                <Form.Control placeholder="discount" name="discount" {...register('discount')} />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>base</Form.Label>
                <Form.Control placeholder="base" name="base" {...register('base')} />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>percentagePDV</Form.Label>
                <Form.Control placeholder="percentagePDV" name="percentagePDV" {...register('percentagePDV')} />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>total</Form.Label>
                <Form.Control placeholder="total" name="total" {...register('total')} />
            </Form.Group>
            <div className="form">
                <p>Article</p>
                <Form.Select aria-label="Article"  {...register('articleName')} className="form-element" >
                {props.articles && props.articles.map((article) => <option value={article.name} >{article.name}</option>)}
                </Form.Select>
            </div>
            <Button type='submit' variant="primary" className="margin-top">Add</Button>
        </Form>
  
  </>)
}
export default AddInvoiceItem;