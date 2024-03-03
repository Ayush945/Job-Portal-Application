/**
 * Ayush Thapa
 * Find Salaries page
 */

import React from 'react'
import { Link } from 'react-router-dom'

function FindSalaries() {
    return (
        <div className='min-h-screen flex flex-col justify-evenly'>
            <div className='ml-44 mr-44'>
                <p className=' text-4xl'>Discover a fulfiling profession that align with your pasion.</p>
                <p className='text-xl mt-5'>Investegate carrers with top job satisfaction, attractive salaries, other facorable factors.</p>
            </div>
            <div className='flex justify-evenly items-center py-4 px-4 border border-gray-300 rounded-lg ml-44 mr-44 '>
                <input className='border-none focus:outline-none' placeholder='Job Title'></input>
                <p>|</p>
                <input
                    className=' border-none focus:outline-none'
                    placeholder='Salaries'></input>
                <p>|</p>
                <input className='border-none focus:outline-none' placeholder='Location'></input>
                <p>|</p>
                <div className='border border-blue-200 p-1 rounded-lg bg-blue-400 hover:bg-blue-700 cursor-pointer'><button className=' text-white ml-5 mr-5'>Search</button></div>
            </div>
            <div className=' text-center mt-10 cursor-pointer mb-44'>
                <Link to='/find-companies' className=' text-blue-400 text-xl hover:text-blue-600'>Do you want to search for Companies?</Link>
            </div>
        </div>
    )
}

export default FindSalaries