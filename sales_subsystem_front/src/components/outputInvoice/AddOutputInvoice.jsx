import { useState } from "react";
import { Button, Table } from "react-bootstrap";
import PriceListWithArticles from "./PriceListWithArticles";
import { formatMillis } from "../../utils/time";

const AddOutputInvoice = ({ priceLists }) => {
	const [onePriceVisible, setOnePriceVisible] = useState(false);
	const [copyPriceList, setCopyPriceList] = useState(false);
	const [selectedPriceList, setSelectedPriceList] = useState()
	const [priceList, setPriceList] = useState();

	const handleOnView = (id) => {
		setSelectedPriceList(id);
		setOnePriceVisible(!onePriceVisible);
	}

	return (
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
								<td><Button onClick={() => handleOnView(list.id)}>View</Button></td>
							</tr>
						)}
					</tbody>
				</Table>
			}
			{onePriceVisible && <PriceListWithArticles id={selectedPriceList} companyPib={selectedPriceList.pib} />}
		</>
	)
}
export default AddOutputInvoice;