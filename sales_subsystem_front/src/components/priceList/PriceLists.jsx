import { useState } from "react";
import { Button, Form, Table } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import CopyPriceList from "./CopyPriceList";
import OnePriceList from "./OnePriceList";
import { formatMillis } from "../../utils/time";

const PriceLists = (props) => {
    let navigate = useNavigate();
    const [ onePriceVisible, setOnePriceVisible ] = useState(false);
    const [ copyPriceList, setCopyPriceList ] = useState(false);
    const [ selectedPriceList, setSelectedPriceList ] = useState()

    const handleClick = () => {
        navigate('/addPriceList', { replace: true });
    }
    const handleOnView = (id) => {
        setSelectedPriceList(id)
        setOnePriceVisible(!onePriceVisible)
    }
    const handleOnCopy = (id) => {
        setSelectedPriceList(id);
        setCopyPriceList(!copyPriceList);
    }

    return (<>
        <h1 className="center">Price lists</h1>
        {props.priceLists && <><Table className="table" striped bordered hover>
            <thead className="thead-dark">
                <tr>
                    <th scope="col">Valid from</th>
                    <th scope="col">Company PIB</th>
                </tr>
            </thead>
            <tbody>
                {props.priceLists.map((list) =>
                    <tr>
                        <td>{formatMillis(list.validDate)}</td>
                        <td>{list.pib}</td>
                        <td><Button onClick={()=>handleOnView(list.id)}>View</Button></td>
                        <td><Button onClick={()=>handleOnCopy(list.id)}>Copy</Button></td>
                    </tr>
                   
                )}
            </tbody>

        </Table>
   
        </>
        }
        <div className="component"> <button type="submit" className="btn-primary" onClick={handleClick}>Add price list</button></div>
        { onePriceVisible && <OnePriceList id={selectedPriceList}/>}
        { copyPriceList && <CopyPriceList id={selectedPriceList}/>}

    </>);
}
export default PriceLists;