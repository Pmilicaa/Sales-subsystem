import React from 'react'
import AddBusinessPartnerForm from '../components/businessPartner/AddBusinessPartnerForm'
import BusinessPartnerTable from '../components/businessPartner/BusinessPartnerTable'

const BusinessPartnerPage = ({ companies }) => {
  return (
    <>
      <BusinessPartnerTable companies={companies}/>
      <AddBusinessPartnerForm companies={companies} />
    </>
  )
}

export default BusinessPartnerPage