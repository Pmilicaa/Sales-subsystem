import { useEffect, useState } from "react";
import { Button, Col, ListGroup, Row, Table } from "react-bootstrap";
import { addOutputInvoice } from "../../services/OutputInvoices";
import { getPriceList } from "../../services/PriceListService";
import ArticlePrice from "../articles/ArticlePrice";
import ArticlePriceRow from "../articles/ArticlePriceRow";
import InvoiceItemPrice from "../invoiceItem/InvoiceItemPrice";
import OnePriceList from "../priceList/OnePriceList";
import OutputInvoice from "./OutputInvoice";
import PriceListWithArticles from "./PriceListWithArticles";
const AddOutputInvoice =(props)=>{
    const [ onePriceVisible, setOnePriceVisible ] = useState(false);
    const [ copyPriceList, setCopyPriceList ] = useState(false);
    const [ selectedPriceList, setSelectedPriceList ] = useState()
    const [priceList,setPriceList] = useState();
  
  
    const handleOnView = (id) => {
        console.log(id)
        setSelectedPriceList(id);
        setOnePriceVisible(!onePriceVisible);

    }

    const getDate = (priceList)=>{
        const date = priceList.validDate;
        var options = { weekday: 'short', year: 'numeric', month: 'short', day: 'numeric', hour: 'numeric', minute: 'numeric' };
        return (new Date(date).toLocaleDateString('en-US', options));
    }
    return(<>
        {props.priceLists && <><Table className="table" striped bordered hover>
               
                <tbody>
                    {props.priceLists.map((list) =>
                        <tr>
                            <td>{getDate(list)}</td>
                            <td>{list.pib}</td>
                            <td><Button onClick={()=>handleOnView(list.id)}>View</Button></td>
                        </tr>
                       
                    )}
                </tbody>
    
            </Table>
       
            </>
            }
{onePriceVisible && <PriceListWithArticles id={selectedPriceList}/> }
  
    
    </>)
}
export default AddOutputInvoice;