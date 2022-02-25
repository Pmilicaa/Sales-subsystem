import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import { getPriceList } from "../../services/PriceListService";
import CopyPriceListWithPDV from "./CopyPriceListWithPDV";
import { formatMillis } from "../../utils/time";

const CopyPriceList = (props) => {
  const [priceList, setPriceList] = useState([]);
  useEffect(() => {
    getPriceLists(props.id);
  }, []);

  const getPriceLists = (id) => {
    getPriceList(id).then((price) => setPriceList(price));
  }

  return (<>
    <h1 className="center">Copy price list</h1>
    {priceList && <Table className="table" striped bordered hover>
      <thead className="thead-dark">
        <tr>
          <th scope="col">Valid from</th>
          <th scope="col">Company PIB</th>
        </tr>
      </thead>
      <tbody>
        {priceList.map((price) =>
          <tr>
            <td>{formatMillis(price.validDate)}</td>
            <td>{price.pib}</td>
          </tr>)
        }
      </tbody>
    </Table>}
    <CopyPriceListWithPDV priceList={priceList} id={props.id} />
  </>);
}
export default CopyPriceList;