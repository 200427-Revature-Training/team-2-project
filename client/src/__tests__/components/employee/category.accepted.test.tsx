import React from 'react';
import { CategoryAcceptedComponent, CategoryAcceptedComponentProps } from '../../../components/pages/employee/category-views/category-accepted/category.accepted.component';
import { mount, shallow } from 'enzyme';
import { getTicketByAcceptedCategory } from '../../../remote/employee.remote';

jest.mock('../../../remote/employee.remote');
const mockgetTicketByAccepted = getTicketByAcceptedCategory as any;

const commonProps: CategoryAcceptedComponentProps = {
    setView: jest.fn()
}

const mockfn = jest.fn();

// describe('category.accepted.component', () => {

//     test('should render', () => {
//         const props: CategoryAcceptedComponentProps = {
//             setView: () => {}
//         }
//         const wrapper = mount(<CategoryAcceptedComponent {...props} />);
//         console.log(wrapper.debug());
//         expect(wrapper).toBeDefined();
//     })
// });

describe('category.accepted', () => {

        beforeEach(() => {
        jest.clearAllMocks();
    })
    
    test('should render', () => {
        const wrapper = mount(<CategoryAcceptedComponent {...commonProps} />);
        expect(wrapper).toBeDefined();
    });
})