import { useEffect, useState } from "react";
import { Button, Form, Table } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { getPriceList } from "../../services/PriceListService";

const OnePriceList = (props) => {
    const [priceList, setPriceList]= useState([]);
    useEffect(()=>{
        getPriceLists(props.id);
    }
    ,[]);
    console.log(props.id);
    const getDate = (date) => {
        var options = { weekday: 'short', year: 'numeric', month: 'short', day: 'numeric', hour: 'numeric', minute: 'numeric' };
        return (new Date(date).toLocaleDateString('en-US', options));
       
    }
    const getPriceLists = (id)=>{
    console.log(id);
       const prices =  getPriceList(id).then((price)=>setPriceList(price));
       console.log(priceList)
      
    }
    
    return (<>
        <h1 className="center">One price list</h1>
        {priceList && <Table className="table" striped bordered hover>
            <thead className="thead-dark">
                <tr>
                    <th scope="col">Valid from</th>
                    <th scope="col">Article name</th>
                    <th scope="col">Article group</th>
                    <th scope="col">Price</th>
                    <th scope="col">Company PIB</th>
                </tr>
            </thead>
            <tbody>
            {priceList.map((price)=>
            <tr>
            <td>{getDate(price.validDate)}</td>
            <td>{price.articleName}</td>
            <td>{price.articleGroupName}</td>
            <td>{price.price}</td>
            <td>{price.pib}</td>
        </tr>)
    }

            </tbody>

        </Table>}
    </>);
}
export default OnePriceList;