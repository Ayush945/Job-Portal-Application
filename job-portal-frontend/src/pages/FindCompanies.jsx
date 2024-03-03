/**
 * Ayush Thapa
 * Find Companies Page
 */
import React from 'react'
import { Link } from 'react-router-dom'

function FindCompanies() {
    return (
        <div className='min-h-screen flex flex-col justify-evenly'>
            <div className='ml-44 mr-44'>
                <p className=' text-4xl'>Discover excellent workplace</p>
                <p className='text-xl mt-5'>Gain entry to extensive comany evaluations.</p>
            </div>
            <div className='flex justify-between items-center py-4 px-4 border border-gray-300 rounded-lg ml-44 mr-44 '>
                <input className='border-none focus:outline-none' placeholder='Find Companies'></input>
                <div className='border border-blue-200 p-1 rounded-lg bg-blue-400 hover:bg-blue-700 cursor-pointer'><button className=' text-white ml-5 mr-5'>Search</button></div>
            </div>
            <div className=' text-center mt-10 cursor-pointer mb-44'>
                <Link to='/find-salaries' className=' text-blue-400 text-xl hover:text-blue-600'>Do you want to search for salaries?</Link>
            </div>
        </div>
    )
}

export default FindCompanies