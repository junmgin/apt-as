
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RegistrationDefectRegistrationManager from "./components/listers/RegistrationDefectRegistrationCards"
import RegistrationDefectRegistrationDetail from "./components/listers/RegistrationDefectRegistrationDetail"

import ManagementDefectManagementManager from "./components/listers/ManagementDefectManagementCards"
import ManagementDefectManagementDetail from "./components/listers/ManagementDefectManagementDetail"

import ContractorDefectContractorManager from "./components/listers/ContractorDefectContractorCards"
import ContractorDefectContractorDetail from "./components/listers/ContractorDefectContractorDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/registrations/defectRegistrations',
                name: 'RegistrationDefectRegistrationManager',
                component: RegistrationDefectRegistrationManager
            },
            {
                path: '/registrations/defectRegistrations/:id',
                name: 'RegistrationDefectRegistrationDetail',
                component: RegistrationDefectRegistrationDetail
            },

            {
                path: '/managements/defectManagements',
                name: 'ManagementDefectManagementManager',
                component: ManagementDefectManagementManager
            },
            {
                path: '/managements/defectManagements/:id',
                name: 'ManagementDefectManagementDetail',
                component: ManagementDefectManagementDetail
            },

            {
                path: '/contractors/defectContractors',
                name: 'ContractorDefectContractorManager',
                component: ContractorDefectContractorManager
            },
            {
                path: '/contractors/defectContractors/:id',
                name: 'ContractorDefectContractorDetail',
                component: ContractorDefectContractorDetail
            },




    ]
})
