import React, { useEffect, useState } from 'react'
import axios from "axios";
import AddUnitForm from '../components/unitsOfMeasure/AddUnitForm'
import UnitTable from '../components/unitsOfMeasure/UnitTable'

const UnitsOfMeasuresPage = () => {
  const [ units, setUnits ] = useState([])

  useEffect(() => {
    getAllUnits()
  }, [])

  function addUnit(unit){
    setUnits(units => [...units, unit])
  }

  async function getAllUnits(){
    var res = await axios.get("http://localhost:8080/unitOfMeasures")
    setUnits(res.data)
  }

  return (
    <>
      <UnitTable units={units}/>
      <AddUnitForm addUnit={addUnit}/>
    </>
  )
}

export default UnitsOfMeasuresPage