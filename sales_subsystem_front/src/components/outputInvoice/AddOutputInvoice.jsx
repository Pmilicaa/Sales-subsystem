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
import { formatMillis } from "../../utils/time";

const AddOutputInvoice =({ priceLists })=>{
    const [ onePriceVisible, setOnePriceVisible ] = useState(false);
    const [ copyPriceList, setCopyPriceList ] = useState(false);
    const [ selectedPriceList, setSelectedPriceList ] = useState()
    const [priceList,setPriceList] = useState();
  
  
    const handleOnView = (id) => {
        console.log(id)
        setSelectedPriceList(id);
        setOnePriceVisible(!onePriceVisible);

    }

    return(
        <>
            {
                priceLists && 
                <Table className="table" striped bordered hover>
                    <thead className="thead-dark">
                        <tr>
                            <th scope="col">Price list date</th>
                            <th scope="col">Price list company</th>
                            <th scope="col">Price list options</th>
                        </tr>
                    </thead>
                    <tbody>
                        {priceLists.map((list) =>
                            <tr key={list.pib}>
                                <td>{formatMillis(list.validDate)}</td>
                                <td>{list.pib}</td>
                                <td><Button onClick={()=>handleOnView(list.id)}>View</Button></td>
                            </tr>
                        )}
                    </tbody>
                </Table>
            }
            {onePriceVisible && <PriceListWithArticles id={selectedPriceList} companyPib={selectedPriceList.pib}/> }
        </>
    )
}
export default AddOutputInvoice;