import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import { getPriceList } from "../../services/PriceListService";

const OutputInvoice =(props)=>{
    console.log(props.invoice);

    // <th scope="col">Number account</th>
    // <th scope="col">Total base</th>
    // <th scope="col">Total pdv</th>
    // <th scope="col">Total payment</th>
    // <th scope="col">Release date</th>
   
    return (<>
        {
            <tbody>
                <tr>
            <td>{props.invoice.numberAccount}</td>
            <td>{props.invoice.totalBase}</td>
            <td>{props.invoice.totalPDV}</td>
            <td>{props.invoice.totalPayment}</td>
            <td>{props.invoice.releaseDate}</td>
      
      </tr>
            </tbody>

        }
    </>);
}
export default OutputInvoice;
   
    
    
