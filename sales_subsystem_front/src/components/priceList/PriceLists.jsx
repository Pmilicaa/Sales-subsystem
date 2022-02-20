import { Form, Table } from "react-bootstrap";

const PriceLists = (props) => {
    const getDate = ()=>{
        let date;
        for (let index = 0; index < props.priceLists.length; index++) {
            date = props.priceLists[index].validDate;
        }
        var options = { weekday: 'short', year: 'numeric', month: 'short', day: 'numeric', hour: 'numeric', minute: 'numeric' };
        return (new Date(date).toLocaleDateString('en-US', options));
    }
   
    return (<>
        <h1 className="center">Price lists</h1>
        {props.priceLists && <Table className="table" striped bordered hover>
            <thead className="thead-dark">
                <tr>
                    <th scope="col">Valid from</th>
                    <th scope="col">Price</th>
                    <th scope="col">Article name</th>
                    <th scope="col">Article group</th>
                    <th scope="col">Company PIB</th>
                </tr>
            </thead>
            <tbody>
                {props.priceLists.map((list) => 
                    <tr>
                        <td>{getDate()}</td>
                        <td>{list.price}</td>
                        <td>{list.articleName}</td>
                        <td>{list.articleGroupName}</td>
                        <td>{list.pib}</td>
                    </tr>
                )}
            </tbody>

        </Table>}
    </>);
}
export default PriceLists;